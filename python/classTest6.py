class Person:
    count = 0

    def __init__(self, name):
        self.name = name
        Person.count += 1

person1 = Person('홍길동')
print(person1.count)
person2 = Person('허균')
print(person2.count)