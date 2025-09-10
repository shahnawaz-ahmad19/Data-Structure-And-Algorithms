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
            lecture = os.path.basename(os.path.dirname(relative_path))
            problem = file.replace(".java", "")
            problems.append((lecture, problem, relative_path))

# Group by Lecture folder
lectures = {}
for lecture, problem, path in problems:
    # Only include folders that look like "LectureXX"
    if re.match(r"Lecture\d+", lecture, re.IGNORECASE):
        lectures.setdefault(lecture, []).append((problem, path))

# Generate README.md content
lines = []
lines.append("# 📘 DSA Practice Repository\n")
lines.append("This repository contains my solutions to **Data Structures and Algorithms (DSA)** problems.\n")
lines.append("---\n")
lines.append("## 📑 Problem Index\n")

for lecture, problems in sorted(lectures.items()):
    lines.append(f"### {lecture}\n")
    lines.append("| Problem Name | Solution Link |")
    lines.append("|--------------|---------------|")
    # Sort problems numerically if names end with numbers (Pattern01, Pattern02…)
    def sort_key(x):
        match = re.search(r"(\d+)$", x[0])
        return int(match.group()) if match else float('inf')
    for problem, path in sorted(problems, key=sort_key):
        lines.append(f"| {problem} | [View Code]({path}) |")
    lines.append("\n")

# Write to README.md
with open(readme_file, "w", encoding="utf-8") as f:
    f.write("\n".join(lines))

print("✅ README.md updated successfully!")