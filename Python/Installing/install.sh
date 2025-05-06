if [[ $(command -v brew) == "" ]]; then
    echo "Installing Hombrew"
    /usr/bin/ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"
else
    echo "Updating Homebrew"
    brew update
fi


if [[ $(command -v python3) == "" ]]; then
  echo "Installing python3"
  brew install python3
fi


python3 -m pip install pyside6
python3 -m pip install pyqt5
python3 -m pip install colorama

if [[ $(command -v git) == "" ]]; then
  echo "Installing git"
  brew install git
fi


git clone https://github.com/MakiDevelops/orgST.git

echo "cloned orgST git. open your terminal and run 'cd orgST'"
echo "you can run git pull https://github.com/MakiDevelops/orgST.git to update"
echo "to update, run git pull (link.git)
