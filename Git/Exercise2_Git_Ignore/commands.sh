#!/usr/bin/env bash
set -e

echo "temporary application log" > application.log
mkdir -p log
echo "debug log line" > log/debug.log

cat > .gitignore <<'EOF'
*.log
log/
EOF

git status --ignored
git check-ignore -v application.log
git check-ignore -v log/debug.log
git add .gitignore
git commit -m "Ignore log files and log folder"
git status
