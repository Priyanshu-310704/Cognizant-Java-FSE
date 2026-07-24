#!/usr/bin/env bash
set -e

git checkout master
git status
git checkout -b GitWork
cat > hello.xml <<'EOF'
<message>
  <text>Hello from GitWork branch</text>
</message>
EOF
git add hello.xml
git commit -m "Add hello xml from GitWork"

git checkout master
cat > hello.xml <<'EOF'
<message>
  <text>Hello from master branch</text>
</message>
EOF
git add hello.xml
git commit -m "Add hello xml from master"

git log --oneline --graph --decorate --all
git diff master..GitWork

# This merge intentionally creates a conflict.
git merge GitWork || true
cat hello.xml

cat > hello.xml <<'EOF'
<message>
  <text>Hello from master and GitWork branch</text>
  <status>Conflict resolved with a combined message</status>
</message>
EOF
git add hello.xml
git commit -m "Resolve hello xml merge conflict"

printf "*.orig\n*.BACKUP.*\n*.BASE.*\n*.LOCAL.*\n*.REMOTE.*\n" >> .gitignore
git add .gitignore
git commit -m "Ignore merge backup files"

git branch -a
git branch -d GitWork
git log --oneline --graph --decorate
