if(Get-Service -Name 'git' -ErrorAction SilentlyContinue) {
    Write-Host 'Git CLI already installed, continuing. . . '
}

else {
    Write-Host 'Installing Git CLI'
    winget install -e --id Git.Git
}



if(Get-Service -Name 'python' -ErrorAction SilentlyContinue)
{
    Write-Host 'Updating Python. . .'
    winget upgrade -e --id Python.Python.3.11
}

else {
    Write-Host 'Installing Python. . .'
    winget install -e --id Python.Python.3.11
}



python -m pip install pyside6
git clone https://github.com/MakiDevelops/orgST.git