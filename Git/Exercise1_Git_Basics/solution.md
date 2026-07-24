# Exercise 1: Git Basics

## Objective

Set up Git configuration, configure Notepad++ as the default editor, create a
local repository named `GitDemo`, add `welcome.txt`, commit it, and push it to a
remote repository.

## Solved Steps

1. Verify Git installation.

```bash
git --version
```

2. Configure user name and email.

```bash
git config --global user.name "Your Name"
git config --global user.email "your.email@example.com"
git config --list
```

3. Configure Notepad++ as default Git editor.

```bash
alias npp='notepad++'
git config --global core.editor "notepad++ -multiInst -notabbar -nosession -noPlugin"
git config --global --get core.editor
```

4. Create and initialize the local repository.

```bash
mkdir GitDemo
cd GitDemo
git init
ls -a
```

5. Create `welcome.txt`, add it to Git, and commit.

```bash
echo "Welcome to Git hands-on lab." > welcome.txt
git status
git add welcome.txt
git commit
```

Use the editor to enter a multiline commit message:

```text
Add welcome text file

Created welcome.txt as the first tracked file in GitDemo.
```

6. Connect to the remote repository and push.

```bash
git remote add origin https://github.com/<your-user>/GitDemo.git
git pull origin master --allow-unrelated-histories
git push -u origin master
```

If the default branch is `main`, use `main` instead of `master`.

## Expected Result

`git status` should show a clean working tree after commit and push. The remote
repository should contain `welcome.txt`.
