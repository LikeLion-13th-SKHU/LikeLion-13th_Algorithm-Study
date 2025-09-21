word = input().upper()
uni_word = list(set(word))

count_list = [word.count(x) for x in uni_word]

max_count = max(count_list)

if count_list.count(max_count) > 1:
    print("?")
else:
    max_index = count_list.index(max_count)
    print(uni_word[max_index])
    