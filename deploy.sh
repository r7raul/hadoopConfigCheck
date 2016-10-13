#!/bin/bash
git clone --depth=50 --branch=master https://github.com/r7raul1984/hadoopConfigCheck.git  deploy
cd deploy
###
git config user.name "Travis-CI"
git config user.email "travis@kamranicus.com"

git remote add upstream https://github.com/r7raul/hadoopConfigCheck.git
git remote set-url origin "https://${GH_TOKEN}@${GH_REF}"

#git fetch upstream > /dev/null 2>&1 || exit 1
echo "git checkout master"
git checkout master
echo "git status"
git status
echo "Merge..."
git merge upstream/master  -m "Deploying site for $CURRENT_COMMIT"
#git add -A
#git commit --allow-empty -m "Deploy" || exit 1
#git pull --rebase upstream master
echo "Push..."
git push origin master > /dev/null 2>&1 || exit 1
#echo "Committing and pushing to GH"
#
#git config user.name "Travis-CI"
#git config user.email "travis@kamranicus.com"
#git add -A
#git commit --allow-empty -m "Deploying site for $CURRENT_COMMIT" || exit 1
#git push origin master > /dev/null 2>&1 || exit 1

#echo "Pushed deployment successfully"


exit 0
