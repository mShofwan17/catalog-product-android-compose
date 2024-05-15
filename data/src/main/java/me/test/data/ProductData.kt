package me.test.data

val jsonProducts = """
    [
  {
    "id": 1,
    "name": "Air Force 1 Jester XX Black Sonic Yellow",
    "brand": "Nike",
    "price": 1500000,
    "description": "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum diam tellus, porta a condimentum vitae, posuere quis tortor. Praesent sed cursus dolor. Integer dapibus at nulla eget fermentum. Aenean consequat, ligula quis egestas ornare, neque erat scelerisque tellus, in vulputate neque risus eu erat. Pellentesque dignissim dictum sapien eget pretium. Fusce ullamcorper elit et elit finibus ullamcorper. Quisque ullamcorper interdum turpis, vitae volutpat felis porttitor nec. Nullam accumsan turpis ut feugiat egestas. Etiam tempus ullamcorper elit, sit amet gravida purus. Curabitur euismod id lacus sed malesuada. Nulla ipsum ex, tempor non enim vitae, ullamcorper lobortis arcu.",
    "imageUrl": "https://drive.usercontent.google.com/download?id=107U2YOkWin7mjHMWB-bZpMmauuPXPjOy",
    "isFavourite": 1
  },
  {
    "id": 2,
    "name": "Run Star Hike Three Color Unisex",
    "brand": "Converse",
    "price": 1500000,
    "description": "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum diam tellus, porta a condimentum vitae, posuere quis tortor. Praesent sed cursus dolor. Integer dapibus at nulla eget fermentum. Aenean consequat, ligula quis egestas ornare, neque erat scelerisque tellus, in vulputate neque risus eu erat. Pellentesque dignissim dictum sapien eget pretium. Fusce ullamcorper elit et elit finibus ullamcorper. Quisque ullamcorper interdum turpis, vitae volutpat felis porttitor nec. Nullam accumsan turpis ut feugiat egestas. Etiam tempus ullamcorper elit, sit amet gravida purus. Curabitur euismod id lacus sed malesuada. Nulla ipsum ex, tempor non enim vitae, ullamcorper lobortis arcu.",
    "imageUrl": "https://drive.usercontent.google.com/download?id=1YfdjxPdiuLmNLLMDue_XxxvdDcaoNxLb",
    "isFavourite": 0
  },
  {
    "id": 3,
    "name": "Air Jordan 1 Retro High Obsidian UNC",
    "brand": "Nike",
    "price": 1500000,
    "description": "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum diam tellus, porta a condimentum vitae, posuere quis tortor. Praesent sed cursus dolor. Integer dapibus at nulla eget fermentum. Aenean consequat, ligula quis egestas ornare, neque erat scelerisque tellus, in vulputate neque risus eu erat. Pellentesque dignissim dictum sapien eget pretium. Fusce ullamcorper elit et elit finibus ullamcorper. Quisque ullamcorper interdum turpis, vitae volutpat felis porttitor nec. Nullam accumsan turpis ut feugiat egestas. Etiam tempus ullamcorper elit, sit amet gravida purus. Curabitur euismod id lacus sed malesuada. Nulla ipsum ex, tempor non enim vitae, ullamcorper lobortis arcu.",
    "imageUrl": "https://drive.usercontent.google.com/download?id=1UD1C3-8pCzaJ4oIztDPMXRIc2VwQW4IW",
    "isFavourite": 0
  },
  {
    "id": 4,
    "name": "Air Force 1 Jester XX Black Sonic Yellow",
    "brand": "Nike",
    "price": 1000000,
    "description": "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum diam tellus, porta a condimentum vitae, posuere quis tortor. Praesent sed cursus dolor. Integer dapibus at nulla eget fermentum. Aenean consequat, ligula quis egestas ornare, neque erat scelerisque tellus, in vulputate neque risus eu erat. Pellentesque dignissim dictum sapien eget pretium. Fusce ullamcorper elit et elit finibus ullamcorper. Quisque ullamcorper interdum turpis, vitae volutpat felis porttitor nec. Nullam accumsan turpis ut feugiat egestas. Etiam tempus ullamcorper elit, sit amet gravida purus. Curabitur euismod id lacus sed malesuada. Nulla ipsum ex, tempor non enim vitae, ullamcorper lobortis arcu.",
    "imageUrl": "https://drive.usercontent.google.com/download?id=19lz1UUwp90XVIOQNNr_ebcLflAf2PLXv",
    "isFavourite": 0
  },
  {
    "id": 5,
    "name": "Run Star Hike Three Color Unisex",
    "brand": "Converse",
    "price": 2500000,
    "description": "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum diam tellus, porta a condimentum vitae, posuere quis tortor. Praesent sed cursus dolor. Integer dapibus at nulla eget fermentum. Aenean consequat, ligula quis egestas ornare, neque erat scelerisque tellus, in vulputate neque risus eu erat. Pellentesque dignissim dictum sapien eget pretium. Fusce ullamcorper elit et elit finibus ullamcorper. Quisque ullamcorper interdum turpis, vitae volutpat felis porttitor nec. Nullam accumsan turpis ut feugiat egestas. Etiam tempus ullamcorper elit, sit amet gravida purus. Curabitur euismod id lacus sed malesuada. Nulla ipsum ex, tempor non enim vitae, ullamcorper lobortis arcu.",
    "imageUrl": "https://drive.usercontent.google.com/download?id=1nofcfmJnXi1jDF2msz5XiU-03SXDZCH4",
    "isFavourite": 1
  },
  {
    "id": 6,
    "name": "Air Force 1 Shadow Beige Pale Ivory",
    "brand": "Nike",
    "price": 1500000,
    "description": "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum diam tellus, porta a condimentum vitae, posuere quis tortor. Praesent sed cursus dolor. Integer dapibus at nulla eget fermentum. Aenean consequat, ligula quis egestas ornare, neque erat scelerisque tellus, in vulputate neque risus eu erat. Pellentesque dignissim dictum sapien eget pretium. Fusce ullamcorper elit et elit finibus ullamcorper. Quisque ullamcorper interdum turpis, vitae volutpat felis porttitor nec. Nullam accumsan turpis ut feugiat egestas. Etiam tempus ullamcorper elit, sit amet gravida purus. Curabitur euismod id lacus sed malesuada. Nulla ipsum ex, tempor non enim vitae, ullamcorper lobortis arcu.",
    "imageUrl": "https://drive.usercontent.google.com/download?id=1SIvn20hCD7spkogMLG4-PidrwGvbAifi",
    "isFavourite": 0
  }
]
""".trimIndent()