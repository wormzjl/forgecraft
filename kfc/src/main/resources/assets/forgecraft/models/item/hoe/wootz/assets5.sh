#! /bin/bash

values=(
0
0.0001
0.0002
0.0003
0.0004
0.0005
0.001
0.0011
0.0012
0.0013
0.0014
0.002
0.0021
0.0022
0.0023
0.003
0.0031
0.0032
0.004
0.0041
0.005
0.01
0.0101
0.0102
0.0103
0.0104
0.011
0.0111
0.0112
0.0113
0.012
0.0121
0.0122
0.013
0.0131
0.014
0.02
0.0201
0.0202
0.0203
0.021
0.0211
0.0212
0.022
0.0221
0.03
0.0301
0.0302
0.031
0.0311
0.04
0.0401
0.041
0.05
0.1
0.101
0.102
0.103
0.104
0.11
0.111
0.112
0.113
0.12
0.121
0.122
0.13
0.131
0.14
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