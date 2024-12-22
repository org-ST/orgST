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
python3 -m pip install colorama

if [[ $(command -v git) == "" ]]; then
  echo "Installing git"
  brew install git
fi


git clone https://github.com/MakiDevelops/orgST.git

