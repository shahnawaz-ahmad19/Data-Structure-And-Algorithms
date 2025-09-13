import os
import re

# Project setup
base_dir = "src"   # Only scan inside /src
readme_file = "README.md"

# Collect all Java files
problems = []
for root, _, files in os.walk(base_dir):
    for file in files:
        if file.endswith(".java"):
            relative_path = os.path.join(root, file).replace("\\", "/")
            folder_name = os.path.basename(os.path.dirname(relative_path))
            problem = file.replace(".java", "")
            problems.append((folder_name, problem, relative_path))

# Group by Lecture/Assignment folder
lectures = {}
assignments = {}

for folder, problem, path in problems:
    if re.match(r"Lecture\d+", folder, re.IGNORECASE):
        lectures.setdefault(folder, []).append((problem, path))
    elif re.match(r"Assignment\d+", folder, re.IGNORECASE):
        assignments.setdefault(folder, []).append((problem, path))

# ✅ Sorting helpers
def extract_number(name):
    """Extract trailing digits from LectureXX or AssignmentXX, default inf"""
    match = re.search(r"(\d+)", name)
    return int(match.group()) if match else float("inf")

def problem_sort_key(x):
    match = re.search(r"(\d+)$", x[0])
    return int(match.group()) if match else float("inf")

# Generate README.md content
lines = []
lines.append("# 📘 DSA Practice Repository\n")
lines.append("This repository contains my solutions to **Data Structures and Algorithms (DSA)** problems.\n")
lines.append("---\n")
lines.append("## 📑 Problem Index\n")

# ---------------- Lectures ----------------
if lectures:
    lines.append("## 🎓 Lectures\n")
    for folder in sorted(lectures.keys(), key=extract_number):
        lines.append(f"### {folder}\n")  # Keep full folder name (Lecture01, Lecture02…)
        lines.append("| Problem Name | Solution Link |")
        lines.append("|--------------|---------------|")
        for problem, path in sorted(lectures[folder], key=problem_sort_key):
            lines.append(f"| {problem} | [View Code]({path}) |")
        lines.append("\n")

# ---------------- Assignments ----------------
if assignments:
    lines.append("## 📝 Assignments\n")
    for folder in sorted(assignments.keys(), key=extract_number):
        lines.append(f"### {folder}\n")  # Keep suffix like Assignment08_Tree
        lines.append("| Problem Name | Solution Link |")
        lines.append("|--------------|---------------|")
        for problem, path in sorted(assignments[folder], key=problem_sort_key):
            lines.append(f"| {problem} | [View Code]({path}) |")
        lines.append("\n")

# Write to README.md
with open(readme_file, "w", encoding="utf-8") as f:
    f.write("\n".join(lines))

print("✅ README.md updated successfully!")