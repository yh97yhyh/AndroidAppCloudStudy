# n = int(input())

# for i in range(1, 10):
#     print('{} * {} = {}'.format(n, i, n*i))

# for i in range(2, 10):
#     for j in range(1, 10):
#         print('{} * {} = {}'.format(i, j, i*j))
#     print()

# li = []
# for i in range(11):
#     if(i%2 == 0):
#         continue
#     li.append(i)
# print(li)

a, b = input().split()
a = int(a)
b = int(b)

def divide(a, b):
    x = int(a / b)
    y = a % b
    return (x, y)

print(divide(a, b))