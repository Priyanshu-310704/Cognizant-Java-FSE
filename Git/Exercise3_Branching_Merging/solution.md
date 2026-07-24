# Exercise 3: Branching and Merging

## Objective

Create a branch named `GitNewBranch`, add files in the branch, compare branch
changes with the trunk, merge the branch into `master`, inspect the log, and
delete the branch.

## Solved Steps

Run from the `GitDemo` repository.

1. Make sure the trunk is clean.

```bash
git checkout master
git status
```

2. Create and switch to the new branch.

```bash
git branch GitNewBranch
git branch -a
git checkout GitNewBranch
```

3. Add a file and commit it in the branch.

```bash
echo "This file was created in GitNewBranch." > branch-note.txt
git status
git add branch-note.txt
git commit -m "Add branch note"
```

4. Compare branch and trunk.

```bash
git diff master..GitNewBranch
git difftool master..GitNewBranch
```

If P4Merge is configured, `git difftool` opens the visual comparison.

5. Merge into trunk and observe log.

```bash
git checkout master
git merge GitNewBranch
git log --oneline --graph --decorate
```

6. Delete the merged branch.

```bash
git branch -d GitNewBranch
git branch -a
git status
```

## Expected Result

`branch-note.txt` exists on `master`, the log shows the branch commit as part of
the history, and `GitNewBranch` is deleted locally.
