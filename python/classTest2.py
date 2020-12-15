class Person:
    def __init__(self):
        self.hi = 'Hello'

    def hello(self):
        print(self.hi)

person = Person()
person.hello()
print(person.hi)