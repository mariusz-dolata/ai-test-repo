# AI Test Repository - GitHub Copilot Instructions

**ALWAYS follow these instructions first and fallback to additional search and context gathering only if the information in these instructions is incomplete or found to be in error.**

This is a minimal test repository designed for AI agent development and testing. The repository contains basic documentation and serves as a sandbox environment for AI coding agents to practice and validate their capabilities.

## Repository Overview

This repository is located at `/home/runner/work/ai-test-repo/ai-test-repo` and contains:
- README.md - Basic project documentation
- .github/ - GitHub configuration and workflows directory (created as needed)

The repository is intentionally minimal to serve as a testing ground for AI agents learning to work with GitHub repositories.

## Environment Setup and Validation

### Pre-installed Tools (Always Available)
The development environment includes these verified working tools:

- **Git**: `git version 2.50.1` - Located at `/usr/bin/git`
- **Python 3**: `python3 --version` → `Python 3.12.3` - Located at `/usr/bin/python3`
- **Node.js**: `node --version` → `v20.19.4` - Located at `/usr/local/bin/node`
- **npm**: `npm --version` → `10.8.2` - Located at `/usr/local/bin/npm`
- **Docker**: `docker --version` → `Docker version 28.0.4, build b8034c0` - Located at `/usr/bin/docker`
- **GCC**: `gcc --version` → `gcc (Ubuntu 13.3.0-6ubuntu2~24.04) 13.3.0` - Located at `/usr/bin/gcc`
- **Make**: `make --version` → `GNU Make 4.3` - Located at `/usr/bin/make`
- **pip**: `python3 -m pip --version` → `pip 24.0`

### Environment Information
- **Operating System**: Linux (Ubuntu-based)
- **User**: runner
- **Shell**: bash
- **Working Directory**: `/home/runner/work/ai-test-repo/ai-test-repo`

## Working Effectively

### Initial Repository Setup
Run these commands to orient yourself in the repository:

```bash
cd /home/runner/work/ai-test-repo/ai-test-repo
pwd  # Verify you're in the correct directory
git status  # Check repository state
git remote -v  # Verify remote configuration
```

### Repository Navigation
Use these commands to explore the repository structure:

```bash
# View repository structure
ls -la

# Show all files including hidden ones
find . -type f -name "*" ! -path "./.git/*"

# View README content
cat README.md

# Check git history
git log --oneline --all

# Check current branch
git branch -a
```

### Development Environment Testing
Validate your development environment with these commands:

```bash
# Test Python functionality
echo 'print("Python is working")' > test_python.py
python3 test_python.py
rm test_python.py

# Test Node.js functionality  
echo 'console.log("Node.js is working");' > test_node.js
node test_node.js
rm test_node.js

# Test C compilation
printf '#include <stdio.h>\nint main() {\n    printf("C compilation is working\\n");\n    return 0;\n}' > test.c
gcc test.c -o test
./test
rm test.c test

# Test npm functionality (in temporary directory)
cd /tmp
npm init -y
rm package.json
cd /home/runner/work/ai-test-repo/ai-test-repo
```

### Git Operations
All standard git operations work as expected:

```bash
# Check repository status
git status

# View differences
git diff
git diff --name-only

# View commit history
git log --oneline -10

# Check branches
git branch -a

# Note: Do not use git push, git commit, or git add directly
# Use the report_progress tool instead for committing changes
```

## File Operations and Development

### Creating and Editing Files
Standard file operations work normally:

```bash
# Create files
echo "content" > filename.txt
touch newfile.txt

# Edit files (use str_replace_editor tool instead of manual editing)
# View files
cat filename.txt
head -20 filename.txt
tail -20 filename.txt

# Delete files
rm filename.txt
```

### Testing Changes
When making any changes to the repository:

1. **Always validate file operations:**
   ```bash
   # Test file creation
   echo "test content" > test.txt
   cat test.txt
   rm test.txt
   ```

2. **Check git status after changes:**
   ```bash
   git status
   git diff --name-only
   ```

3. **Use report_progress tool to commit changes** (never use git commit directly)

## Validation Scenarios

### Basic Functionality Test
Run this complete validation sequence after making any changes:

```bash
# Navigate to repository root
cd /home/runner/work/ai-test-repo/ai-test-repo

# Verify tools are working
python3 --version
node --version
git --version

# Test repository access
git status
cat README.md

# Test file operations
echo "validation test" > validation.txt
cat validation.txt
rm validation.txt

# Check for any uncommitted changes
git status
```

### Development Environment Validation
Always run this environment check when starting work:

```bash
# Check all essential tools
which git python3 node npm gcc make docker
echo "All tools verified: $(date)"

# Verify repository state
pwd
git branch
git status --porcelain
```

## Build and Test Information

### No Build System Present
This repository currently has no build system or dependencies. Key points:

- **No package.json** - No Node.js dependencies to install
- **No requirements.txt** - No Python dependencies to install  
- **No Makefile** - No make targets to build
- **No CI/CD** - No GitHub Actions workflows configured
- **No tests** - No automated test suite present

### If Adding Build System
When adding a build system to this repository:

1. **For Node.js projects:**
   ```bash
   npm init -y
   # Edit package.json as needed
   npm install  # NEVER CANCEL - Wait for completion (usually < 2 minutes)
   npm run build  # If build script exists
   ```

2. **For Python projects:**
   ```bash
   echo "requests==2.31.0" > requirements.txt
   python3 -m pip install -r requirements.txt  # NEVER CANCEL - Wait for completion (usually < 5 minutes)
   ```

3. **Always document timing expectations in these instructions when adding builds**

## Time Expectations and Timeouts

### Current Operations (No Builds)
All current operations complete quickly:
- File operations: < 1 second
- Git commands: < 2 seconds  
- Tool version checks: < 1 second
- Python/Node.js script execution: < 2 seconds
- C compilation: < 5 seconds

### Future Build Operations
**CRITICAL**: If build systems are added later:
- **NEVER CANCEL** any build or test commands
- Set timeouts to **60+ minutes** for build commands
- Set timeouts to **30+ minutes** for test commands
- Wait for all operations to complete fully
- Document actual timing in these instructions

## Common Tasks

### Repository Exploration
```bash
# Quick repository overview
cd /home/runner/work/ai-test-repo/ai-test-repo
ls -la
cat README.md
git log --oneline -5

# Detailed exploration  
find . -type f ! -path "./.git/*"
git branch -a
git remote -v
```

### Adding New Files
```bash
# Create new file
echo "new content" > newfile.txt

# Verify creation
ls -la newfile.txt
cat newfile.txt

# Check git status
git status

# Use report_progress tool to commit (never git add/commit directly)
```

### Environment Verification
```bash
# Quick environment check
echo "Repository: $(pwd)"
echo "User: $(whoami)"  
echo "Git: $(git --version)"
echo "Python: $(python3 --version)"
echo "Node: $(node --version)"
echo "Time: $(date)"
```

## Troubleshooting

### Common Issues
1. **"Permission denied" errors**: Check file permissions with `ls -la`
2. **"Command not found"**: Verify tool availability with `which <command>`
3. **Git issues**: Ensure you're in repository root with `pwd`
4. **File not found**: Use `find . -name "filename"` to locate files

### Recovery Commands
```bash
# Reset to clean state (use carefully)
git status
git checkout -- .  # Only if needed to revert changes

# Verify clean state
git status --porcelain  # Should show no output

# Re-verify environment
cd /home/runner/work/ai-test-repo/ai-test-repo
python3 --version && node --version && git --version
```

## Critical Reminders

- **ALWAYS** validate commands work before documenting them
- **NEVER** use git commit, git add, or git push directly - use report_progress tool
- **ALWAYS** run commands from `/home/runner/work/ai-test-repo/ai-test-repo`
- **TEST** all file operations before committing changes
- **VERIFY** git status after any repository modifications
- **NEVER CANCEL** long-running build or test commands (when they exist)
- **DOCUMENT** actual command timing when adding new build systems

## Quick Reference

### Essential Commands
```bash
# Navigate to repo
cd /home/runner/work/ai-test-repo/ai-test-repo

# Check status
git status && pwd

# View repository
ls -la && cat README.md

# Test tools  
python3 --version && node --version && git --version
```

### Validation Checklist
- [ ] Navigate to correct directory
- [ ] Verify git status is clean
- [ ] Test file operations
- [ ] Check tool availability
- [ ] Validate any changes made
- [ ] Use report_progress for commits