#Test Script

clear
git status
#git add --all :/
#IFS= read -r -p "Enter commit message: " com
#git commit -m "${com}"
#echo $(git branch)
git branch
gitBranch=$(git symbolic-ref --short HEAD)

read -p "Is this the correct branch (y/n)?" CONT
if [ "$CONT" = "y" ]; then
  
  git add --all :/
  IFS= read -r -p "Enter commit message: " com
  git commit -m "${com}"
  git push nmd ${gitBranch}
  git push github ${gitBranch}
else
  echo "Please switch to the correct branch to continue"
fi


#git push nmd ${com1}
#git push github ${com1}
