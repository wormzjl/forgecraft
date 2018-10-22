#! /bin/bash

values=(
0
0.0001
0.0002
0.001
0.0011
0.002
0.01
0.0101
0.011
0.02
0.1
0.101
0.11
1
)

IFS= read -r -p "Enter Material: " mat
IFS= read -r -p "Enter Tool: " tool

for i in ${values[@]}; do
    touch ${mat}${tool}"_"${i}".json"
    cat >${mat}${tool}_${i}.json <<EOL
{
  "parent": "forgecraft:item/${tool}",
  "textures": {
    "particle": "forgecraft:items/${mat}/${i}",
    "texture": "blocks/planks_oak",
    "texture1": "forgecraft:items/${mat}/${i}"
  }
}
EOL
done
exit 0