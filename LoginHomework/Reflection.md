# Reflection

這次我先請 AI 檢查原本的登入視窗程式是否有問題

AI 指出原本程式中有幾個問題。

第一個問題是使用 `==` 比較 String，例如：

`t1.getText() == "admin"`

在 Java 中，`==` 比較的是物件是否相同，而不是字串內容，因此我改成使用：

`account.equals("admin")`

第二個問題是原本使用 `setLayout(null)`，但是沒有替 JLabel、JTextField 和 JButton 設定 `setBounds()`，因此元件可能無法正常顯示。我最後改用 `FlowLayout`，讓 Swing 自動排列元件。

第三個問題是 `setVisible(true)` 原本在加入元件之前執行。我把它移到視窗設定與元件加入完成之後再執行。

另外，原本密碼輸入欄使用 `JTextField`，我改成 `JPasswordField`，讓密碼輸入時不會直接顯示文字。

這次使用 AI 的方式主要是讓 AI 幫忙檢查原本程式的問題，再由我依照原因修改程式。AI 產生的程式即使看起來合理，也不代表每一個寫法都是正確或適合的，仍然需要自己理解與測試。