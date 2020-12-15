class Person:
    def __init__(self, n, a):
        self.name = n
        self.age = a
    
    def hello(self):
        print('Hello {}.'.format(self.name))
        print('당신은 {}살 입니다.'.format(self.age))

person = Person('홍길동', 20)
person.hello()