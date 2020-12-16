import requests
import pymysql

url = 'https://dapi.kakao.com/v3/search/book?'
header = {
    'Authorization':'KakaoAK 664fd8e249303d5990b0bf0d6f3b1fc7'
}

params = {
    'query':'사람',
    'size':10,
    'page':1
}

data = requests.get(url, headers=header, params=params).json()

books = data['documents']

con = pymysql.connect(host='localhost', user='root', 
                        password='1539', db='crawl_data', charset='utf8')
cursor = con.cursor() # 한 줄씩 수행
sql = """INSERT INTO books(title, authors, publisher, price) 
        VALUES(%s, %s, %s, %s)"""

for item in books:
    title = item['title']
    authors = ', '.join(item['authors'])
    publisher = item['publisher']
    price = item['price']
    cursor.execute(sql, (title, authors, publisher, price))

con.commit()
con.close()