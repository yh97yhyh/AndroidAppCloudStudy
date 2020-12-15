'''
비공개 속성
'''

class Person:
    def __init__(self, name, age):
        self.name = name
        self.__age = age
    
    def hello(self):
        print('Hello {}.'.format(self.name))
        print('당신은 {}살 입니다.'.format(self.__age))

person = Person('홍길동', 20)
person.hello()
print(person.__age)
person.__age = 10