cmake_minimum_required(VERSION 3.10)
project(
        orgST
        LANGUAGES CXX
)

if(NOT DEFINED NOSSL)
file(GLOB SOURCES CONFIGURE_DEPENDS third-party/CryptoPP/*.cpp)

add_library(
        cryptopp
        SHARED
        ${SOURCES}
)
endif()

add_executable(
        orgST

        src/Main.cpp
        src/Methods.cpp
        src/Extras/Flag.cpp
        src/OrgID/Client.cpp
        src/OrgID/Encrypt.cpp
        src/OrgID/KeyLoader.cpp
        src/Variables/AppData.cpp
        src/Variables/ChannelData.cpp
)

if (DEFINED NOSSL)
    target_compile_definitions(orgST PRIVATE "NOSSL")
endif()

if (NOT DEFINED NOSSL)
    target_include_directories(orgST PRIVATE third-party/CryptoPP)
    target_link_libraries(orgST PRIVATE cryptopp cpr)
    find_package(OpenSSL 3 REQUIRED)
    target_link_libraries(orgST PRIVATE OpenSSL::Crypto OpenSSL::SSL)
endif()