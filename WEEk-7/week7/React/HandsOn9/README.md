---
Project Structure
```
cricketapp/
├── node_modules/                  # Project dependencies
├── public/
│   └── index.html                 # Main HTML file
├── src/
│   ├── components/                # Reusable components
│   │   ├── ListofPlayers.js       # Displays all players
│   │   ├── Scorebelow70.js        # Displays players with score < 70
│   │   ├── OddPlayers.js          # Displays odd index players
│   │   ├── EvenPlayers.js         # Displays even index players
│   │   └── ListofIndianPlayers.js # Displays merged player list
│   ├── App.js                     # Main component rendering all sections
│   ├── App.css                    # Component-level styles
│   ├── index.js                   # React entry point
│   ├── index.css                  # Global styles
│   ├── setupTests.js              # For testing setup (optional)
│   └── reportWebVitals.js         # For performance metrics (optional)
├── .gitignore                     # Ignored files and folders
├── package.json                   # Project config and dependencies
├── package-lock.json              # Auto-generated lockfile
```

