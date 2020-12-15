student = {'name':'홍길동', 'major':'정보통신학과', 'score':3.5}
print(student)
scores = {1:3.5, 2:4.0, 3:4.3, 4:4.2}
print(scores)

# print(student['name'])
# print(student['major'])
# print(scores[1])
# print(scores[2])

# del(student['name'])
# print(student)

# student['name'] = '홍길동'

print(student.items())
print(student.keys())
print(student.values())


print(list(student.items()))
print(list(student.keys()))
print(list(student.values()))