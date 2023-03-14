//
//  PokemonListCard.swift
//  iosApp
//
//  Created by Neil Jedric Dellosa on 2/3/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import Alamofire

struct PokemonListCard: View {

    @State var image: UIImage? = nil
    
    var body: some View {
        HStack(alignment: .top, spacing:8) {
            VStack(alignment: .leading, spacing: 10) {
                Text("Bulbasaur")
                VStack(spacing:10) {
                    Text("grass")
                        .padding(8)
                        .overlay(
                            RoundedRectangle(cornerRadius: 8)
                                .stroke(.white, lineWidth: 2)
                        )
                }
                .frame(maxWidth:.infinity,alignment: .leading)
            }
            if let image = image {
                Image(uiImage: image)
                        .resizable()
                        .aspectRatio(contentMode:.fill)
                        .frame(maxWidth:UIScreen.screenWidth)
            }
    
        }
        .padding(10)
        .background(Color(hex:0xFF90EE90,alpha:1))
        .cornerRadius(10)
        .frame(height:150)
        .frame(width:(UIScreen.screenWidth))
        .onAppear(perform: loadImage)
    }
    func loadImage()  {
            // Replace "urlToVectorImage" with the URL of the vector image you want to download.
            let url = URL(string: "urlToVectorImage")!
            
            AF.request(url).responseData { response in
                switch response.result {
                case .success(let data):
                    if let image = UIImage(data: data) {
                        self.image = image
                    }
                case .failure(let error):
                        print(error)
                }
            }
        }
}

struct PokemonListCard_Previews: PreviewProvider {
    static var previews: some View {
        PokemonListCard()
    }
}
