# Contributing Style

This document is intended to guide contributors on how to unify the style of the project. Please strictly adhere to this document.

## Branch Style

**Important: Before it is allowed, please merge into the 'dev' branch instead of the 'main' branch.**

**The purpose of each branch**

- **'main'**: Used to release stable versions.

- **'dev'**: Used for daily development and maintenance.

- **'feature/title'**: Used to develop new features. These branches are created from the 'develop' branch.

- **'bugfix/title'**: Used to fix bugs. These branches are created from the 'dev' branch.

- **'release'**: Used for release versions. These branches are created from the 'develop' branch and merge into 'main' branch.

**Rules**
- Use '-' to replace spaces.
- Use '\\' and a name that describe their purpose to distinguish branches of the same type, such as 'feature\add-new-model'.


## Commit Style

**Format**

    {type}(optional, scope): {description}

Example: "feat(README): create README template."

**type**

- **fix**: bug fix
- **feat**: add new features
- **build**: construct related
- **docs**: document related
- **style**: code format related
- **refactor**: code refactoring
- **test**: test related
- **chore**: regular code maintenance
