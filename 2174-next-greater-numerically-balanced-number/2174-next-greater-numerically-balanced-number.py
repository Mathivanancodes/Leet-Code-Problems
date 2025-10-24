from itertools import permutations

class Solution:
    balanced_numbers = None

    @staticmethod
    def init_balanced_numbers():
        s = set()
        bases = [
            "1", "22", "122", "333", "1333", "4444", "14444", "22333", "55555",
            "122333", "155555", "224444", "666666", "1224444", "1666666",
            "2255555", "3334444", "7777777", "12255555"
        ]

        for base in bases:
            for p in set(permutations(sorted(base))):
                s.add(int("".join(p)))
        return sorted(s)

    def __init__(self):
        if Solution.balanced_numbers is None:
            Solution.balanced_numbers = Solution.init_balanced_numbers()

    def nextBeautifulNumber(self, n: int) -> int:
        for x in Solution.balanced_numbers:
            if x > n:
                return x
        return -1