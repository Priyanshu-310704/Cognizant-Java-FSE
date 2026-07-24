#!/usr/bin/env bash
set -e

git --version
git config --global user.name "Your Name"
git config --global user.email "your.email@example.com"
git config --global core.editor "notepad++ -multiInst -notabbar -nosession -noPlugin"
git config --list

mkdir -p GitDemo
cd GitDemo
git init
echo "Welcome to Git hands-on lab." > welcome.txt
git status
git add welcome.txt
git commit -m "Add welcome text file" -m "Created welcome.txt as the first tracked file in GitDemo."

# Replace the URL before running remote commands.
# git remote add origin https://github.com/<your-user>/GitDemo.git
# git pull origin master --allow-unrelated-histories
# git push -u origin master
