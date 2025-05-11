"""
      orgST - A fun java console with apps
      Copyright (C) 2025  Wdboyes13, MakiDevelops, Table37

      This program is free software: you can redistribute it and/or modify
      it under the terms of the GNU General Public License as published by
      the Free Software Foundation, either version 3 of the License, or any later version.

      This program is distributed in the hope that it will be useful,
      but WITHOUT ANY WARRANTY; without even the implied warranty of
      MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
      GNU General Public License for more details.

      You should have received a copy of the GNU General Public License
      along with this program.  If not, see https://www.gnu.org/licenses/.
"""
import requests
import base64
from cryptography.hazmat.primitives import serialization, hashes
from cryptography.hazmat.primitives.asymmetric import padding
HOST = 'http://localhost:5000'
# Load the public key
with open('public_key.pem', 'rb') as f:
    public_key = serialization.load_pem_public_key(f.read())

def submit(username, password, url):
    passw = public_key.encrypt(
        password.encode(),   # IMPORTANT: Encrypt bytes
        padding.OAEP(
            mgf=padding.MGF1(algorithm=hashes.SHA256()),
            algorithm=hashes.SHA256(),
            label=None
        )
    )
    usr = public_key.encrypt(
        username.encode(),
        padding.OAEP(
            mgf=padding.MGF1(algorithm=hashes.SHA256()),
            algorithm=hashes.SHA256(),
            label=None
        )
    )
    data = {
        'usr': base64.b64encode(usr).decode(),   # base64 encode
        'pass': base64.b64encode(passw).decode()
    }
    response = requests.post(url, data=data)
    print(response.text)  # See what the server says back!
    return response.text

def crusr():
    username = input("Enter a username: ")
    password = input("Enter a password: ")
    url = f'{HOST}/create'
    return submit(username, password, url)

def verusr():
    username = input("Enter your username: ")
    password = input("Enter your password: ")
    url = f'{HOST}/verify'
    return submit(username, password, url)

