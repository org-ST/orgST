from flask import Flask, request, render_template
app = Flask(__name__)
@app.route('/')
def index():
    render_template('index.html')
app.run(port=3000, debug=True)