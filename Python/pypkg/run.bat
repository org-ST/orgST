@echo off
SET SCRIPT_DIR=%~dp0
CD /D %SCRIPT_DIR%PY
python main.py
PAUSE