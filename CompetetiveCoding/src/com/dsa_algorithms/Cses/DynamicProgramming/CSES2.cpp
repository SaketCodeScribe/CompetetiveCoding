#include <bits/stdc++.h>
using namespace std;

static const int VAL = 1'000'000'000;

int minimumCoins(int n, int target, vector<int>& coins) {
    const int INF = 1e9;
    vector<int> dp(target + 1, INF);

    dp[0] = 0;

    for (int i = 1; i <= target; i++) {
        for (int j = 0; j < n; j++) {
            if (coins[j] <= i) {
                dp[i] = min(dp[i], dp[i - coins[j]] + 1);
            } else {
                break;
            }
        }
    }

    return (dp[target] < VAL) ? dp[target] : -1;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, target;
    cin >> n >> target;

    vector<int> coins(n);
    for (int i = 0; i < n; i++) {
        cin >> coins[i];
    }

    sort(coins.begin(), coins.end());

    cout << minimumCoins(n, target, coins) << "\n";
    return 0;
}