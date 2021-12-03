from selenium import webdriver
from bs4 import BeautifulSoup
import mysql.connector

url = [
    'https://www.youtube.com/feed/trending?bp=6gQJRkVleHBsb3Jl'
]

def main():
    driver = webdriver.chrome()
    driver.get('https://www.youtube.com/feed/trending?bp=6gQJRkVleHBsb3Jl'.format(url))
    content = driver.page_source.encode('utf-8').strip()
    soup = BeautifulSoup(content, 'lxml')

    id = soup.findAll('a', id= 'video-title')
    titles = soup.findAll('a', id= 'video-title')
    name = soup.findAll('a', id= 'video-title')
    publish = soup.findAll('span', class_='style-scope ytd-video-meta-block')
    print('Channel: https://youtube.com/{}'.format(url))

    i = 0

    for title in titles[:20]:
        print('\n{}\t{}\t{}\t{}\t{}'.format(title.text, id[i].text, publish[i].text, name[i].text))
        i+=1
    main()

    # koneksi ke database
    db = mysql.connector.connect(user="root",database="cobaapi")
    cursor = db.cursor()

    add_new = ("INSERT INTO NO_2"
               "(channelId, title, channelNama, publishedAt)"
               "VALUE (%s,%s,%s,%s)")
    data_news = (id, title, name, publish, 'Fix')

    cursor.excute(add_new,data_news)

    db.commit()
    cursor.close()
    db.close()