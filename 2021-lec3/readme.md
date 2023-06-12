
```
git config http.proxy yourproxy

git submodule update --init
```

Error message you may encounter :
'''

Failed to connect to github.com port 443: Timed out
fatal: clone of 'https://github.com/Berkeley-CS61B/library-sp21' into submodule path 'mylocalPC basefolder/cs61b/library-sp21' failed
Failed to clone 'library-sp21'. Retry scheduled
'''

Fix: Change https to http

https://stackoverflow.com/questions/11410017/git-submodule-update-over-https

1. Edit the .gitmodules, replace https with http
2. Run `git submodules sync`
3. Do the update again `git submodule update --init`
4. open project from intellij with by specifying the project structure, adding the libraray from the folder of submodules
