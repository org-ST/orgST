# This is the order it is recommended to port orgST to other languages
- Core App - This includes the main TUI + AppData (See More below)
- Calculator
- ChannelViewer  
- orgID  
- AppLoader
- Salvade Loader (Part of AppLoader)  
- Salvade (Optional)  
- HomeRoom (Optional)

# Files from Java Version, organized by section, so you know what to port  
## Core App
- ./Main.java
- ./App.java
- ./Variables/AppData.java
- ./Extras/Flag.java
- ./Methods.java
## OrgID
- ./OrgID/Client.java
- ./OrgID/KeyLoader.java
- ./OrgID/Encrypt.java
## Calculator
- ./channelapps/CTPorted.java
- ./Variables/Ops.java  
## ChannelViewer
- ./channelapps/AppTester.java
- ./Extras/WebOpener.java
- ./Extras/ChannelMenu.java
- ./Extras/ChannelViewer.java
- ./Extras/py.java
- ./Extras/GetUsrChannels.java
- ./Extras/Apps/ChannelHelper.java
- ./Extras/Apps/Channel.java
## AppLoader
- ./horo.java
- ./AppLoader.java
- ./Salvade/Main.java
- ./Salvade/DLpypy.java

# Languages to be ported to
- C (Claimed by Wdbvoyes13)
- 3DS BASIC (Claimed by MakiDevelops)  
- Rust (Claimed by Wdboyes13)

Copyright © 2025 Wdboyes13  
SPDX-License-Identifier: BSD-3-Clause  

This document is licensed under the BSD 3-Clause License.   
You may use, modify, and redistribute it under the terms of that license.  
See <https://opensource.org/licenses/BSD-3-Clause> for details.  

Last updated: July 14, 2025  
