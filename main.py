f0=0
f1=1
n=6

for i in range(10):
    print(f1, end=' ')
    n = f1-1+f0+(f1*1)
    f0 = f1
    f1 = n

    # Untuk Fibonacci sendiri saya belum menemukan solusinya, yang saya pelajari di Fibonacci sendiri yaitu angka sebelumnya akan ditambah angka sekarang misalnya
    # deret ke - 5 = 3
    # deret ke - 6 = 5
    # deret ke - 7 = 3 + 5 = 8
    # deret ke - 8 = 5 + 8 = 13
    # kurang lebih saya menangkapnya seperti itu, tapi untuk soal yg kakak kasih ke saya masih bingung bagaimana dapat melompat ke 5 lalu 27