#Test Script

clear
git status
git add --all :/
IFS= read -r -p "Enter commit message: " com
git commit -m "${com}"
#echo $(git branch)
git branch
IFS= read -r -p "Enter Branch name: " com1
git push nmd ${com1}
git push github ${com1}
