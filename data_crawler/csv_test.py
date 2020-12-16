import csv
import pymysql

file = open('police.csv', 'r', encoding='utf-8')
reader = csv.reader(file)

con = pymysql.connect(host='localhost', user='root',
                        password='1539', db='crawl_data', charset='utf8')
cursor = con.cursor() # 한 줄씩 수행
sql = """INSERT INTO police(title, tel, homepage, roadaddress) 
        VALUES(%s, %s, %s, %s)"""

for line in reader:
    title = line[0]
    tel = line[1]
    homepage = line[2]
    roadaddress = line[3]
    print("{}:{}:{}:{}".format(title, tel, homepage, roadaddress))
    cursor.execute(sql, (title, tel, homepage, roadaddress))

# con.commit()
# con.close()

