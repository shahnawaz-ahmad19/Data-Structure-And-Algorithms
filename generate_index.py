import os
import re

# Configuration
base_dir = "src"       # scan only inside src
readme_file = "README.md"

# Collect all Java files under src
problems = []  # tuples: (folder_name, problem_name, relative_path)
for root, _, files in os.walk(base_dir):
    for file in files:
        if file.endswith(".java"):
            # relative path with forward slashes for GitHub links
            rel_path = os.path.join(root, file).replace("\\", "/")
            folder_name = os.path.basename(os.path.dirname(rel_path))
            problem_name = file.rsplit(".java", 1)[0]
            problems.append((folder_name, problem_name, rel_path))

# Group into lectures / assignments / topics (everything else)
lectures = {}
assignments = {}
topics = {}

for folder, problem, path in problems:
    if re.match(r"Lecture\d+", folder, re.IGNORECASE):
        lectures.setdefault(folder, []).append((problem, path))
    elif re.match(r"Assignment\d+", folder, re.IGNORECASE):
        assignments.setdefault(folder, []).append((problem, path))
    else:
        topics.setdefault(folder, []).append((problem, path))

# Sorting helpers
def extract_number(name):
    """Return the first number found in the name for numeric sorting; otherwise +inf"""
    m = re.search(r"(\d+)", name)
    return int(m.group(1)) if m else float("inf")

def problem_sort_key(item):
    """Sort problems by trailing number if present, else alphabetical"""
    name = item[0]
    m = re.search(r"(\d+)$", name)
    return (int(m.group(1)), "") if m else (float("inf"), name.lower())

# Build README content
lines = []
lines.append("# 📘 DSA Practice Repository")
lines.append("")
lines.append("This repository contains my Java solutions for DSA topics, lectures and assignments.")
lines.append("---")
lines.append("")
lines.append("## 📑 Problem Index")
lines.append("")

# Lectures section (numeric sort)
if lectures:
    lines.append("## 🎓 Lectures")
    lines.append("")
    for folder in sorted(lectures.keys(), key=extract_number):
        lines.append(f"### {folder}")
        lines.append("")
        lines.append("| Problem Name | Solution Link |")
        lines.append("|--------------|---------------|")
        for problem, path in sorted(lectures[folder], key=problem_sort_key):
            lines.append(f"| {problem} | [View]({path}) |")
        lines.append("")

# Assignments section (numeric sort)
if assignments:
    lines.append("## 📝 Assignments")
    lines.append("")
    for folder in sorted(assignments.keys(), key=extract_number):
        lines.append(f"### {folder}")
        lines.append("")
        lines.append("| Problem Name | Solution Link |")
        lines.append("|--------------|---------------|")
        for problem, path in sorted(assignments[folder], key=problem_sort_key):
            lines.append(f"| {problem} | [View]({path}) |")
        lines.append("")

# Topics / Packages section (alphabetical)
if topics:
    lines.append("## 📦 Topics / Packages")
    lines.append("")
    # Sort folder names alphabetically, case-insensitive
    for folder in sorted(topics.keys(), key=lambda s: s.lower()):
        lines.append(f"### {folder}")
        lines.append("")
        lines.append("| Problem Name | Solution Link |")
        lines.append("|--------------|---------------|")
        for problem, path in sorted(topics[folder], key=problem_sort_key):
            lines.append(f"| {problem} | [View]({path}) |")
        lines.append("")

# Write README
with open(readme_file, "w", encoding="utf-8") as f:
    f.write("\n".join(lines))

print(f"✅ {readme_file} updated — includes Lectures, Assignments, and Topics (e.g. Basic_Maths, Recursion).")
