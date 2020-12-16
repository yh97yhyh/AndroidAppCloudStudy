import requests
import xmltodict
import json
import pymysql

# serviceKey = '8AQWwNbdZg%2BkVGRXoN30BXN0dirkL%2BK%2B7lz1tHAD0JNlM1pbDu2vlF9b6uBLdjHzdQl03wAK%2FoZwwJc1UmPLmA%3D%3D'

url = """http://open.gyeongnam.go.kr/rest/gyeongnampoliceoffice/getGyeongnampoliceofficeList?serviceKey=8AQWwNbdZg%2BkVGRXoN30BXN0dirkL%2BK%2B7lz1tHAD0JNlM1pbDu2vlF9b6uBLdjHzdQl03wAK%2FoZwwJc1UmPLmA%3D%3D&pageNo=1&numOfRows=10"""


content = requests.get(url).content
dic = xmltodict.parse(content)
jsonString = json.dumps(dic['rfcOpenApi']['body'], ensure_ascii=False)
jsonObj = json.loads(jsonString)
data = jsonObj['data']
stations = data['list']

con = pymysql.connect(host='localhost', user='root',
                        password='1539', db='crawl_data', charset='utf8')
cursor = con.cursor() # 한 줄씩 수행
sql = """INSERT INTO police(title, tel, homepage, roadaddress) 
        VALUES(%s, %s, %s, %s)"""

for item in stations:
    title = item['title']
    tel = item['tel']
    homepage = item['homepage']
    roadaddress = item['roadaddress']
    # sigungu = item['sigungu']
    # entid = item['entid']
    print("{},{},{},{}".format(title, tel, homepage, roadaddress))
    # cursor.execute(sql, (title, tel, homepage, roadaddress))

# con.commit()
# con.close()