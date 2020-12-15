class Person:
    def __init__(self, name, age):
        self.name = name
        if 0 <= age <= 20:
            self.__age = age
        else:
            age = 0
    
    def inc_age(self):
        self.__age += 1

    def info(self):
        print(self.__age)

person = Person('홍길동', 20)
person.inc_age()
person.info()