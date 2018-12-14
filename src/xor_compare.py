import csv 

ans_expected =  open('/home/gabor/Development/Mi_bme/rovid/ans.csv', newline='\n')
ans_got =  open('anstrue.csv', newline='\n')

expected_reader = csv.reader(ans_expected, delimiter='\n')

got_reader = csv.reader(ans_got, delimiter='\n')
list_expected = list()
list_got = list()
for row in expected_reader:
    list_expected.append(row[0])
for row in got_reader:
    list_got.append(row[0])
got_right = 0
for i in range(len(list_expected)):
    if(list_expected[i] == list_got[i]):
        got_right += 1
    
print(got_right/len(list_expected))