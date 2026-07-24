# Exercise 5: Cleanup and Push

## Objective

Verify that `master` is clean, list branches, pull remote changes, push pending
local changes, and verify the remote repository.

## Solved Steps

Run from the `GitDemo` repository after completing the earlier exercises.

1. Switch to trunk and verify clean status.

```bash
git checkout master
git status
```

2. List branches.

```bash
git branch -a
```

3. Pull latest remote changes.

```bash
git pull origin master
```

If the remote uses `main`, run:

```bash
git pull origin main
```

4. Push pending local commits.

```bash
git push origin master
```

or:

```bash
git push origin main
```

5. Confirm the local and remote history.

```bash
git status
git log --oneline --graph --decorate --all -n 10
```

## Expected Result

`git status` should report a clean working tree. The remote repository should
show the commits from the Git hands-on exercises, including `.gitignore`,
`branch-note.txt`, and resolved `hello.xml`.
