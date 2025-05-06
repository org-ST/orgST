@echo off
SET SCRIPT_DIR=%~dp0
CD /D %SCRIPT_DIR%
python -m pip install -r requirements.txt