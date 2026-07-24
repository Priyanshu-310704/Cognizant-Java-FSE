#!/usr/bin/env bash
set -e

git checkout master
git status
git branch GitNewBranch
git branch -a
git checkout GitNewBranch
echo "This file was created in GitNewBranch." > branch-note.txt
git add branch-note.txt
git commit -m "Add branch note"
git diff master..GitNewBranch
git checkout master
git merge GitNewBranch
git log --oneline --graph --decorate
git branch -d GitNewBranch
git branch -a
git status
