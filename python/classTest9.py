class Vehicle:
    def __init__(self, speed):
        self.speed = speed

    def speed_up(self):
        self.speed += 10
    
    def speed_dn(self):
        self.speed -= 10


class Car(Vehicle):
    def __init__(self, speed, wheels, seats):
        Vehicle.__init__(self, speed)
        self.wheels = wheels
        self.seats = seats
    
    def info(self):
        print(self.speed, self.wheels, self.seats)

car = Car(100, 4, 4)
car.speed_up()
car.info()