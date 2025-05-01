This is a Kotlin Multiplatform project targeting Android, iOS, Desktop.

* `/composeApp` is for code that will be shared across your Compose Multiplatform applications.
  It contains several subfolders:
  - `commonMain` is for code that’s common for all targets.
  - Other folders are for Kotlin code that will be compiled for only the platform indicated in the folder name.
    For example, if you want to use Apple’s CoreCrypto for the iOS part of your Kotlin app,
    `iosMain` would be the right folder for such calls.

* `/iosApp` contains iOS applications. Even if you’re sharing your UI with Compose Multiplatform, 
  you need this entry point for your iOS app. This is also where you should add SwiftUI code for your project.


Learn more about [Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html)…

* `/Android Screenshots`

<img width="386" alt="Screenshot 2025-05-01 at 5 50 37 PM" src="https://github.com/user-attachments/assets/66baf42f-356c-4a66-9e21-77ee0ddd6523" />
<img width="386" alt="Screenshot 2025-05-01 at 5 50 45 PM" src="https://github.com/user-attachments/assets/3e36750c-c29e-4c75-b37f-5ac65b1fbe06" />
<img width="386" alt="Screenshot 2025-05-01 at 5 54 51 PM" src="https://github.com/user-attachments/assets/25da6b55-5e66-489b-bc9b-a54682f39b88" />


* `/IOS Screenshots`

<img width="386" alt="Screenshot 2025-05-01 at 5 57 20 PM" src="https://github.com/user-attachments/assets/62a8131b-2e5a-49ba-8490-d06641ff8e65" />
<img width="386" alt="Screenshot 2025-05-01 at 5 57 32 PM" src="https://github.com/user-attachments/assets/fd7129ff-5c01-477b-99b9-fbb9377e74f9" />
<img width="386" alt="Screenshot 2025-05-01 at 5 57 45 PM" src="https://github.com/user-attachments/assets/4a4113f3-4f2a-41f9-a802-a059838c750b" />

* `/Desktop Screenshots`

<img width="988" alt="Screenshot 2025-05-01 at 5 59 40 PM" src="https://github.com/user-attachments/assets/b309b307-2458-442d-ab9c-0e7e91f546b3" />
<img width="988" alt="Screenshot 2025-05-01 at 6 00 20 PM" src="https://github.com/user-attachments/assets/825583b9-2dd3-4bb2-97a1-4c6593059dd2" />
<img width="793" alt="Screenshot 2025-05-01 at 6 00 42 PM" src="https://github.com/user-attachments/assets/d9e4d0df-bd45-4f5d-bbbb-1f55ac4e794d" />




