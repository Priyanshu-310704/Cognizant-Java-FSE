# Exercise 2: Git Ignore

## Objective

Create a `.log` file and a `log` folder, then update `.gitignore` so Git ignores
all `.log` files and the `log/` directory.

## Solved Steps

Run these commands from the `GitDemo` repository created in Exercise 1.

```bash
echo "temporary application log" > application.log
mkdir -p log
echo "debug log line" > log/debug.log
```

Create or update `.gitignore`:

```gitignore
*.log
log/
```

Verify the ignore behavior:

```bash
git status --ignored
git check-ignore -v application.log
git check-ignore -v log/debug.log
```

Commit the `.gitignore` file:

```bash
git add .gitignore
git commit -m "Ignore log files and log folder"
git status
```

## Expected Result

`application.log` and files inside `log/` should appear only under ignored files
when `git status --ignored` is run. Only `.gitignore` is committed.
