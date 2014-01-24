def allSubsets(sets):
    subsets = []
    if(len(sets)==1):
        subsets.append([])
        subsets.append([sets[0]])
        return subsets
    else:
        subsets.extend(allSubsets(sets[:-1]))
        for item in allSubsets(sets[:-1]):
            item.append(sets[-1])
            subsets.append(item)
    return subsets

def allSubsetsWithDup(sets):
    results = [[]]
    path = []
    sets.sort()
    index = 0
    results = help(sets, results, path, index)
    return results 

def help(sets, results, path, index):
    for i in xrange(index, len(sets)):
        if(i > index  and sets[i]==sets[i-1]):
            continue
        path.append(sets[i])
        results.append(list(path))
        help(sets, results, path, i+1)
        path.remove(path[-1])
    return results

def test():
    sets = [1,2,2]
    print allSubsets(sets)
    print allSubsetsWithDup(sets)

if __name__ == "__main__":
    test()
