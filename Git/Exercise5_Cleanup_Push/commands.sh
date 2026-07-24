#!/usr/bin/env bash
set -e

git checkout master
git status
git branch -a
git pull origin master
git push origin master
git status
git log --oneline --graph --decorate --all -n 10
