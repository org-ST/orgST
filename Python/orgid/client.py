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

