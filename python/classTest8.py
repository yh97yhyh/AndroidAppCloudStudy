class Rectangle:
    def __init__(self, width, height):
        self.width = width
        self.height = height

    def area(self):
        return self.width * self.height
    
    def double(self):
        self.width = self.width*2
        self.height = self.height*2
    
    def show(self):
        return (self.width, self.height)

rectangle = Rectangle(4, 5)
print(rectangle.show())
rectangle.double()
print(rectangle.show())
print(rectangle.area())