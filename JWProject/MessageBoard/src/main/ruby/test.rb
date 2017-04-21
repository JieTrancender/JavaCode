# -*- coding: UTF-8 -*-

require 'net/http'
require 'net/https'
require 'json'

def post(uri, referer = '', form_data = {})
	Net::HTTP.start(uri.host, uri.port, use_ssl: uri.scheme == 'https',
		verify_mode: OpenSSL::SSL::VERIFY_NONE) do |http|
		req = Net::HTTP::Post.new(uri)
		req.set_form_data(form_data)
		req.initialize_http_header(
			'User-Agent' => 'Mozilla/5.0 (Windows NT 10.0; WOW64; rv:51.0) Gecko/20100101 Firefox/51.0',
			# 'Cookie' =>
			'Referer' => referer
		)
		res = http.request(req)
	end
end

uri = URI('http://localhost:8080/AddServlet')
# uri.query = 
# URI.encode_www_form(
# 	name: 'JTrancender',
# 	phone: '18681700917',
# 	email: '582865471@qq.com',
# 	title: 'Msg from Ruby',
# 	content: 'I wish to become a Rubyer.',
# 	time: Time.new
# )

r = JSON.generate(
	name: 'JTrancender',
	phone: '18681700917',
	email: '582865471@qq.com',
	title: 'Msg from Ruby',
	content: 'I wish to become a Rubyer.',
	time: Time.new
)
puts post(uri, '', r: r)

res = Net::HTTP.get(URI('http://localhost:8080/AddServlet'))
puts res.body if res.is_a?(Net::HTTPSuccess)

def addData
	uri = URI('http://localhost:8080/AddServlet')
	res = Net::HTTP.post_form(uri, :name => 'JTrancender', :phone => '18681700917', 
		:email => '582865471@qq.com', :title => 'Msg from Ruby', :content => 'I wish to become a Rubyer', 
	:time => Time.new)
	res.body
end

puts addData


# uri = URI('http://localhost:8080/AddServlet')
# res = Net::HTTP.post_form(uri, 'name' => 'JTrancender', 'phone' => '18681700917', 
# 	'email' => '582865471@qq.com', :title => 'Msg from Ruby', :content => 'I wish to become a Rubyer', 
# 	:time => Time.new)
# puts res.body